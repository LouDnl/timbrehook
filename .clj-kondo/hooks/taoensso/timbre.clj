(ns hooks.taoensso.timbre
  (:require [clj-kondo.hooks-api :as api]))

(defn refer-timbre [_]
  (let [fns      ['trace  'debug  'info  'warn  'error  'fatal  'report
                  'tracef 'debugf 'infof 'warnf 'errorf 'fatalf 'reportf]
        new-node (api/list-node
                  [(api/token-node 'require)
                   (api/list-node
                    [(api/token-node 'quote)
                     (api/vector-node
                      [(api/token-node 'taoensso.timbre)
                       (api/keyword-node ':refer)
                       (api/vector-node
                        (mapv api/token-node
                              fns))])])])]
    {:node (with-meta new-node
             {:clj-kondo/ignore [:duplicate-require :unused-referred-var]})}))



#_(defn refer-timbre [{:keys [ns node]}]
  (let [new-node (api/list-node (into [] (concat (api/token-node 'do)
                                                 (map only-args
                                                      ['trace  'debug  'info  'warn  'error  'fatal  'report
                                                       'tracef 'debugf 'infof 'warnf 'errorf 'fatalf 'reportf]))))
        lint-as-str-map (reduce (fn [m f]
                                   (let [full-name (symbol (str *ns* "/" f))]
                                     (assoc m full-name 'clojure.core/str)))
                                 {}
                                 ['trace  'debug  'info  'warn  'error  'fatal  'report])
        lint-as-frmt-map (reduce (fn [m f]
                                   (let [full-name (symbol (str *ns* "/" f))]
                                     (assoc m full-name 'clojure.core/format)))
                                 {}
                                 ['tracef 'debugf 'infof 'warnf 'errorf 'fatalf 'reportf])]
    {:node new-node
     :lint-as (merge lint-as-str-map lint-as-frmt-map)}))
