import React from "react";
import PropTypes from "prop-types"
import "./Movie.css";

function Movie({id, year, title, summary, poster, genres}) {
    return (
        <div class="movie">
            <img src={poster} alt={title} title={title}/>
            <div class="movie-data">
                <h3 className="movie_title">{title}</h3>
                <h5 className="movie_yeader">{year}</h5>
                <p className="movie__summary">{summary.slice(0, 180)}...</p>
                <ul className="movie_genres">
                    {genres.map((genre, index) =>
                        <li className="genres_genre">{index} {genre}</li>)}
                </ul>
            </div>
        </div>
    );
}

Movie.prototype = {
    id: PropTypes.number.isRequired,
    year: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    summary: PropTypes.string.isRequired,
    poster: PropTypes.string.isRequired,
    genres: PropTypes.arrayOf(PropTypes.string).isRequired
};

export default Movie;