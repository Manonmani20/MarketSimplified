package com.example.marketsimplifiedapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class RepositoryResponseModel implements Serializable {

        @SerializedName("id")
        String id = "";
        @SerializedName("owner")
        Owner owner;

        @SerializedName("name")
        String name = "";

        @SerializedName("full_name")
        String fullName = "";

        @SerializedName("description")
        String description = "";
        public class Owner{
                @SerializedName("avatar_url")
                String avatarUrl;

                public String getAvatarUrl() {
                        return avatarUrl;
                }
        }

        public Owner getOwner() {
                return owner;
        }

        public String getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public String getFullName() {
                return fullName;
        }
}
