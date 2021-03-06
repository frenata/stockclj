(ns stocksim.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [stocksim.events :as events]
            [stocksim.views :as views]
            [stocksim.config :as config]
            [stocksim.spec :as spec]
            [com.rpl.specter :as s]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))

#_
(s/select [s/MAP-VALS s/ALL] {:foo [1 2] :bar [3 4]})
