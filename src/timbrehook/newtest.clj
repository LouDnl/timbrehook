(ns timbrehook.newtest
  (:require [taoensso.timbre :as timbre]))
(timbre/refer-timbre)

(infof "%s abcd" 1 2)
(infof "%s %s abcd" 1)
