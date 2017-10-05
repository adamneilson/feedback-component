(ns feedback.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars


(defonce unset-selected {:chosen false
                         :reaction nil})

(defonce app-state
  (reagent/atom unset-selected))


(defn post-feedback "Make a call to a server somewhere with the feedback" [idx]
  (println "SELECTED " idx @app-state))

(defn select-reaction "" [idx]
  (reset! app-state unset-selected)
  (swap! app-state assoc :reaction idx :chosen true)
  (post-feedback idx))


(defn reaction-classes "doc-string" [idx]
  (str "reaction mh1 "
       (if (= (:reaction @app-state) idx)
         "reaction-selected"
         (if (:chosen @app-state)
           " reaction-unselected"))))

;==========================================================
; FEEDBACK COMPONENT
;==========================================================
(defn feedback-render []
  [:div {:class " w8 mt4"}
   [:div {:class "reaction-picker reaction-picker-reaction-selected
                 f5 tc ba b--light-gray w-50 pa2 center br3"
          :dir="ltr"}
    [:div {:class "reaction-prompt gray"}
      (if (:chosen @app-state)
       [:a {:class " "
            :on-click #(do (reset! app-state unset-selected))}"Thanks!"]
        "How would you rate this?")]
    [:span {:class (reaction-classes :love)
            :on-click #(do (select-reaction :love))}
     [:span {:title "shit_face"} "😍"]]
    [:span {:class (reaction-classes :smiley)
            :on-click #(do (select-reaction :smiley))}
     [:span {:title "shit_face"} "😃"]]
    [:span {:class (reaction-classes :neutral)
            :on-click #(do (select-reaction :neutral))}
     [:span {:title "shit_face"} "😐"]]
    [:span {:class (reaction-classes :disappointed)
            :on-click #(do (select-reaction :disappointed))}
     [:span {:title "shit_face"} "😞"]]
    [:span {:class (reaction-classes :shit)
            :on-click #(do (select-reaction :shit))}
     [:span {:title "shit_face"} "💩"]]]])




(defn feedback-did-mount
  "This is where to load any previously submitted feedback
  that the widget may have had"
  [info]
  #_(reset! app-state {:chosen true
                       :reaction :love}))



(defn feedback-did-update
  "Add the reset button"
  [info]
  nil)


(defn feedback-component []
  (reagent/create-class {:reagent-render       feedback-render
                         ;:component-did-mount  feedback-did-mount
                         ;:component-did-update feedback-did-update
                         }))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn page [ratom]
  [feedback-component])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
