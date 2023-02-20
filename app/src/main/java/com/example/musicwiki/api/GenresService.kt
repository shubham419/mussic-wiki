package com.example.musicwiki.api

import com.example.musicwiki.models.album.AlbumList
import com.example.musicwiki.models.albumdetail.AlbumDetail
import com.example.musicwiki.models.artistdetail.ArtistDetail
import com.example.musicwiki.models.artists.ArtistsList
import com.example.musicwiki.models.artisttopalbum.ArtistTopAlbum
import com.example.musicwiki.models.artisttoptrack.ArtistTopTrack
import com.example.musicwiki.models.genres.TopGenresList
import com.example.musicwiki.models.genresdetail.GenresDetail
import com.example.musicwiki.models.track.TracksList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresService {

    @GET("/2.0")
    suspend fun getGenres(
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<TopGenresList>

    @GET("/2.0")
    suspend fun getGenresDetail(
        @Query("method") method: String = "tag.getinfo",
        @Query("tag") tag: String = "disco",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<GenresDetail>

    @GET("/2.0")
    suspend fun getData(
        @Query("method") method: String,
        @Query("tag") tag: String,
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<GenresDetail>

    @GET("/2.0")
    suspend fun getTopAlbums(
        @Query("method") method: String = "tag.gettopalbums",
        @Query("tag") tag: String = "disco",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<AlbumList>

    @GET("/2.0")
    suspend fun getTopArtists(
        @Query("method") method: String = "tag.gettopartists",
        @Query("tag") tag: String = "disco",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<ArtistsList>

    @GET("/2.0")
    suspend fun getTopTracks(
        @Query("method") method: String = "tag.gettoptracks",
        @Query("tag") tag: String = "disco",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<TracksList>

    @GET("/2.0")
    suspend fun getArtistTopTracks(
        @Query("method") method: String = "artist.gettoptracks",
        @Query("artist") artistName: String = "cher",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ):Response<ArtistTopTrack>

    @GET("/2.0")
    suspend fun getArtistTopAlbum(
        @Query("method") method: String = "artist.gettopalbums",
        @Query("artist") artistName: String = "cher",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<ArtistTopAlbum>

    @GET("/2.0")
    suspend fun getArtistDetail(
        @Query("method") method: String = "artist.getinfo",
        @Query("artist") artistName: String = "cher",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("format") format: String = "json"
    ): Response<ArtistDetail>

    @GET("/2.0")
    suspend fun getAlbumDetail(
        @Query("method") method: String = "album.getinfo",
        @Query("api_key") api_key: String = "735a8c90797502423ae992ef346f6b16",
        @Query("artist") artistName: String = "cher",
        @Query("album") albumName:String = "Believe",
        @Query("format") format: String = "json"
    ): Response<AlbumDetail>

}