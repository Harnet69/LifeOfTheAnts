package com.harnet.model;

public enum AntSpecie {
    QUEEN {
        public String toString() {
            return "queen";
        }
    },
    WORKER {
        public String toString() {
            return "worker";
        }
    },
    SOLDIER {
        public String toString() {
            return "soldier";
        }
    },
    DRONE {
        public String toString() {
            return "drone";
        }
    }
}
