package com.example.addfragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

    public class FirebaseServices {
        private static FirebaseServices instance;
        private FirebaseAuth auth;
        private FirebaseFirestore fire;
        private FirebaseStorage storage;

        public FirebaseServices() {
        }

        public FirebaseServices(FirebaseAuth auth, FirebaseServices instance, FirebaseFirestore fire,
                                FirebaseStorage storage) {
            this.auth = auth;
            this.instance = instance;
            this.fire = fire;
            this.storage = storage;

        }

        @Override
        public String toString() {
            return "FirebaseServices{" +
                    "auth=" + auth +
                    ", fire=" + fire +
                    ", storage=" + storage +
                    '}';
        }

        public FirebaseStorage getStorage() {
            return storage;
        }

        public void setStorage(FirebaseStorage storage) {
            this.storage = storage;
        }

        public FirebaseFirestore getFire() {
            return fire;
        }

        public void setFire(FirebaseFirestore fire) {
            this.fire = fire;
        }

        public FirebaseAuth getAuth() {
            return auth;
        }

        public void setAuth(FirebaseAuth auth) {
            this.auth = auth;
        }

        public static FirebaseServices getInstance(){
            if (instance == null)
                instance = new FirebaseServices();
            return instance;
        }

        public static void setInstance(FirebaseServices instance) {
            FirebaseServices.instance = instance;
        }
    }
