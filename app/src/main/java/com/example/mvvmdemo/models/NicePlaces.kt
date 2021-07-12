package com.example.mvvmdemo.models

class NicePlaces {
    var title: String? = null
    var imageUrl: String? = null

    constructor(title: String?, imageUrl: String?) {
        this.imageUrl = imageUrl
        this.title = title
    }

    constructor() {}
}