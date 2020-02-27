package com.example.ontmobileapp.models

class Global {
    companion object {
        var newsUrl: String? = null
        var newsTitle: String? = null
        var newsImg: String? = null
        var changes = mutableListOf<Change>()
        var dateSelect: String? = null
        var groupSelect: String? = null
        var dayOfTheWeekSelect: String? = null
        var groupsGlobal = mutableListOf<Group>()
        var posGroup: Int? = null
        var scheduleList = mutableListOf<Schedule>()
        var listNewsGlobal = mutableListOf<News>()


    }

}