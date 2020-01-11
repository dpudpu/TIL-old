import React from 'react';
import axios from 'axios';
import Movie from "./Movie";

class App extends React.Component {
    state = {
        isLoading: true,
        movies: []
    };

    getMovies = async () => { // axios.get은 완료되기 까지 시간이 좀 걸린다. 그래서 await을 사용
        const {
            data: {
                data: {movies}
            }
        } = await axios.get("https://yts-proxy.now.sh/list_movies.json") // axios가 끝날 때까지 기다린다.
        this.setState({movies, isLoading: false})
    }

    componentDidMount() {
        this.getMovies()
    }

    render() {
        const {isLoading, movies} = this.state;
        return <section class="container">
            {isLoading ? (
                <div class="loader">
                    <span class="laoder_text">Loading...</span>
                </div>
            ) : (
                <div class="movies">
                    {movies.map(movie => (
                        <Movie
                            key={movie.id}
                            id={movie.id}
                            year={movie.year}
                            summary={movie.summary}
                            poster={movie.medium_cover_image}
                            title={movie.title}
                        />
                    ))}
                </div>
            )}
        </section>
    }
}

export default App;
