(defproject trying "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [clj-time "0.15.0"]
                 [hiccup "1.0.5"]
                 [compojure "1.6.1"]]
  :main ^:skip-aot trying.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
