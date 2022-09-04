package com.gst.beginnerapp.model

import com.squareup.moshi.Json

data class Meta(

	@Json(name="next_page")
	val nextPage: Int? = null,

	@Json(name="per_page")
	val perPage: Int? = null,

	@Json(name="total_count")
	val totalCount: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null,

	@Json(name="current_page")
	val currentPage: Int? = null
)