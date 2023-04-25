(ns timbrehook.loggingtest
  (:require [taoensso.timbre :as timbre]))
(timbre/refer-timbre)


(comment "fns added by timbre/refer-timbre and parsed with the hook")
; no clj-kondo linting
(debugf "%s" 1 2)
(debugf "%s %s" 1)
(infof "%s" 1 2)
(infof "%s %s" 2)
(tracef "%s" 1 2)
(tracef "%s %s" 2)
(warnf "%s" 1 2)
(warnf "%s %s" 2)
(warnf "%s %s" 2)

(comment "require fns")
; correct clj-kondo linting
(timbre/debugf "%s" 1 2)
(timbre/debugf "%s %s" 1)
(timbre/infof "%s" 1 2)
(timbre/infof "%s %s" 2)
(timbre/tracef "%s" 1 2)
(timbre/tracef "%s %s" 2)
(timbre/warnf "%s" 1 2)
(timbre/warnf "%s %s" 2)

(comment "full namespace fns")
; correct clj-kondo linting
(taoensso.timbre/debugf "%s" 1 2)
(taoensso.timbre/debugf "%s %s" 1)
(taoensso.timbre/infof "%s" 1 2)
(taoensso.timbre/infof "%s %s" 2)
(taoensso.timbre/tracef "%s" 1 2)
(taoensso.timbre/tracef "%s %s" 2)
(taoensso.timbre/warnf "%s" 1 2)
(taoensso.timbre/warnf "%s %s" 2)

(comment "reference")
; correct clj-kondo linting
(format "%s" 1 2)
(format "%s %s" 1)
