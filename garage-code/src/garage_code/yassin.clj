(ns hello-world.yassin
  (:require [clojure.java.io :as io]))

;; PROBLEM 1 (https://codeforces.com/problemset/problem/4/A)

(defn eval  ;; falls x durch zwei teilbar ist und diese zahl wiederum durch zwei teilbar ist wir YES als Antwort ausgespuckt sonst NEIN
  [x]
  (if (= (rem x 2) 0)
    (if (= (rem (/ x 2) 2) 0)
      "YES")
    "NEIN"))

(eval (rand-int 101))


;; PROBLEM 2 (https://codeforces.com/problemset/problem/71/A)

(def string "In a manner of speaking, that's what numerous people with computers and modems 
apparently have been worrying about since late July.  That's when Oklahoma 
City police raided Davis' software publishing firm and confiscated his 
sophisticated commercial computer bulletin board system.  Authorities allege 
Davis was selling pornographic computerized materials on CD-ROM and through 
files downloaded over phone lines.")

(defn encode
  [x]
  (if (> (count x) 10)
    (str (first x) (- (count x) 2) (last x))
    x))

(map (fn [x] (encode x)) (clojure.string/split string #" "))


;; definiere den Text als string, dann definiere encode und falls ein Wort laenger als 10 Buchstacen hat dann nimm den ersten Buchstaben dann die Anzahl der Buchstaben minus zwei und nimm den letzten, map nimmt jedes Element und setzt es dann in die vorherige Funktion fuer x ein.


;; POBLEM 3 (https://codeforces.com/problemset/problem/231/A) 

(defn tabelle  ;;die Funktion tabelle nimmt n als Argument und wiederholt n mal den Vorgang, welcher zuerst x eine Zahl zwischen 1 und 0 zuordnet und dann weiter zu y geht.
  [n]
  (map
   (fn [x]
     (map (fn [x]
                 (rand-int 2))
          (range 3))) 
   (range n)))

(defn test ;; Die Funktion test zaehlt die gefilterten Zahlen die goeser als 2 sind. Zuerst nimmt map die einzelnen Zahlen und addiert sie mit reduce zusammen.
  [n]
  (count (filter
          (fn [x] (> x 1))
          (map (fn [x] (reduce + x)) (tabelle n)))))

(test 100)



