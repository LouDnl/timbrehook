(ns timbrehook.newtest
  (:require [taoensso.timbre :as timbre :refer [infof]]))
;; (timbre/refer-timbre)

(infof "%s abcd" 1 2)
(infof "%s %s abcd" 1)
