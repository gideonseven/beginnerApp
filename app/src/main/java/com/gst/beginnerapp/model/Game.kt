package com.gst.beginnerapp.model

import com.squareup.moshi.Json

data class Game(

	@Json(name="date")
	val date: String? = null,

	@Json(name="postseason")
	val postseason: Boolean? = null,

	@Json(name="period")
	val period: Int? = null,

	@Json(name="season")
	val season: Int? = null,

	@Json(name="visitor_team_score")
	val visitorTeamScore: Int? = null,

	@Json(name="visitor_team")
	val visitorTeam: Team? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="home_team_score")
	val homeTeamScore: Int? = null,

	@Json(name="time")
	val time: String? = null,

	@Json(name="home_team")
	val homeTeam: Team? = null,

	@Json(name="status")
	val status: String? = null
)