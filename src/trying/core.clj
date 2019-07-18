(ns trying.core

  (:gen-class)



   (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [hiccup.page :use [html5 include-css include-js]]
            [hiccup.element :refer (link-to image)]
            )
   (:import java.util.Date))


; returns current time.
(defn get-time
  []
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (t/time-now))}]
    response))

; returns current date.
(defn get-date
  [greet-name]
  (let [response {:status  200
                  :headers {"Content-Type" "text/html"}
                  :body    (str (.getTime (java.util.Date.)))}]
    response))

; define routes.
(defroutes app
           (GET "/" [] "<h1>Welcome</h1>")
           (GET "/get-time" [] (get-time))
           (GET "/get-date" [] (get-date))
           (route/not-found "<h1>Page not found</h1>"))


(defn layout-base-header
  [page]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:link {:rel "stylesheet" :href "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"}]
    (include-css "/css/custom.css")
    [:script {:src "https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"}]
    [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"}]
    [:script {:src "https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"}]
    ]



   [:body
    [:div {:class "container"
           }
    [:h2 {:class "font-weight-bold"} "lets hope this works"] ]]
   ))



; starting point of server.
(defn -main [& args]
  (run-server app {:port 7000})
  (println "Server started on port 7000"))
