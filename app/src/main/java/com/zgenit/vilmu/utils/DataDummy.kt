package com.zgenit.vilmu.utils

import com.zgenit.vilmu.data.MovieEntity
import com.zgenit.vilmu.data.TVShowEntity

//
// Created by Mfdsix on 22/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

object DataDummy {

    fun getMovies(): List<MovieEntity>{

        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
            1,
            "Gabriel's Inferno Part II",
            "Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
            2020,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg",
            "Romance",
            89,
            "1h 45m",
            "Tosca Musk"
        ))
        movies.add(MovieEntity(
            2,
            "Gabriel's Inferno",
            "An intriguing and sinful exploration of seduction, forbidden love, and redemption, Gabriel's Inferno is a captivating and wildly passionate tale of one man's escape from his own personal hell as he tries to earn the impossible--forgiveness and love.",
            2020,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg",
            "Romance",
            88,
            "2h 2m",
            "Tosca Musk"
        ))
        movies.add(MovieEntity(
            3,
            "Dirty Sexy Saint",
            "Clay Kincaid hates the nickname 'Saint', he got for being too kind to stray animals and desperate people. Especially when it comes to women. With a rough and damaged past that has left him jaded, he doesn't do committed relationships. This is before he meets Samantha Jamieson, an heiress turned runaway in need of help. When she starts to work as a waitress at his bar, he discovers that she is someone truly special and amazing… someone that could warm his damaged heart.",
            2019,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/x96lVzJuFqGinfsG0EcwYwBmuom.jpg",
            "Romance,Drama,Comedy",
            62,
            "1h 44m",
            "Tosca Musk"
        ))
        movies.add(MovieEntity(
            5,
            "The Dark Knight",
            "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
            2008,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/qJ2tW6WMUDux911r6m7haRef0WH.jpg",
            "Drama,Action,Crime,Thriller",
            85,
            "2h 32m",
            "Christopher Nolan"
        ))
        movies.add(MovieEntity(
            6,
            "Spider-Man 2",
            "Peter Parker is going through a major identity crisis. Burned out from being Spider-Man, he decides to shelve his superhero alter ego, which leaves the city suffering in the wake of carnage left by the evil Doc Ock. In the meantime, Parker still can't act on his feelings for Mary Jane Watson, a girl he's loved since childhood.",
            2004,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/olxpyq9kJAZ2NU1siLshhhXEPR7.jpg",
            "Action,Adventure,Fantasy",
            71,
            "2h 7m",
            "Sam Raimi"
        ))
        movies.add(MovieEntity(
            7,
            "Fantastic Four",
            "During a space voyage, four scientists are altered by cosmic rays: Reed Richards gains the ability to stretch his body; Sue Storm can become invisible; Johnny Storm controls fire; and Ben Grimm is turned into a super-strong … thing. Together, these \"Fantastic Four\" must now thwart the evil plans of Dr. Doom and save the world from certain destruction.",
            2005,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/8HLQLILZLhDQWO6JDpvY6XJLH75.jpg",
            "Action,Adventure,Fantasy,Science Fiction",
            57,
            "1h 46m",
            "Tim Story"
        ))
        movies.add(MovieEntity(
            8,
            "Ghost Rider",
            "In order to save his dying father, young stunt cyclist Johnny Blaze sells his soul to Mephistopheles and sadly parts from the pure-hearted Roxanne Simpson, the love of his life. Years later, Johnny's path crosses again with Roxanne, now a go-getting reporter, and also with Mephistopheles, who offers to release Johnny's soul if Johnny becomes the fabled, fiery 'Ghost Rider'.",
            2007,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/1pyU94dAY7npDQCKuxCSyX9KthN.jpg",
            "Thriller,Action,Fantasy",
            55,
            "1h 54m",
            "Mark Steven Johnson"
        ))
        movies.add(MovieEntity(
            9,
            "Hulk",
            "Bruce Banner, a genetics researcher with a tragic past, suffers massive radiation exposure in his laboratory that causes him to transform into a raging green monster when he gets angry.",
            2003,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/qnngKqAcqfH2pBxDoKu5lxzSbTo.jpg",
            "Action,Science Fiction",
            55,
            "2h 18m",
            "Ang Lee"
        ))
        movies.add(MovieEntity(
            10,
            "Batman & Robin",
            "Along with crime-fighting partner Robin and new recruit Batgirl, Batman battles the dual threat of frosty genius Mr. Freeze and homicidal horticulturalist Poison Ivy. Freeze plans to put Gotham City on ice, while Ivy tries to drive a wedge between the dynamic duo.",
            1997,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/bsg0mrxUKyJoL4oSGP5mlhEsqp.jpg",
            "Science Fiction,Action,Fantasy",
            43,
            "2h 5m",
            "Bob Kane"
        ))
        movies.add(MovieEntity(
            11,
            "Daredevil",
            "He dwells in a world of eternal night, but the blackness is filled with sounds and scents, tastes and textures that most cannot perceive. Although attorney Matt Murdock is blind, his other four senses function with superhuman sharpness. By day, Murdock represents the downtrodden. At night he is Daredevil, a masked vigilante stalking the dark streets of the city, a relentless avenger of justice.",
            2004,
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/oCDBwSkntYamuw8VJIxMRCtDBmi.jpg",
            "Fantasy,Action,Crime,Science Fiction,Thriller",
            53,
            "1h 43m",
            "Mark Steven Johnson"
        ))

        return movies
    }

    fun getMovieById(movieId: Int): MovieEntity{
        val movies = getMovies()
        for(movie in movies){
            if(movie.id == movieId){
                return movie
            }
        }
        return MovieEntity()
    }

    fun getTVShows(): List<TVShowEntity>{

         val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(TVShowEntity(
                1,
                "I Am Not An Animal",
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                2004,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
                "Animation,Comedy",
                94,
                "30m"
        ))
        tvShows.add(TVShowEntity(
                2,
                "Given",
                "The played chord made the rusty air and both our eardrums vibrate smoothly. From that moment... our music was born.",
                2019,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
                "Animation,Drama",
                93,
                "23m"
        ))
        tvShows.add(TVShowEntity(
                3,
                "The Promised Neverland",
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n" +
                        "\n" +
                        "However, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                2019,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/yxdeII5tI8qqiERcMxjW9DfB6Gz.jpg",
                "Animation,Mystery,Sci-Fi & Fantasy,Action & Adventure,Drama",
                91,
                "23m"
        ))
        tvShows.add(TVShowEntity(
                4,
                "The Rising of the Shield",
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                2019,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
                "Animation,Action & Adventure,Sci-Fi & Fantasy,Drama",
                91,
                "24m"
        ))
        tvShows.add(TVShowEntity(
                5,
                "Banana Fish",
                "Nature made Ash Lynx beautiful; nurture made him a cold ruthless killer. A runaway brought up as the adopted heir and sex toy of \"Papa\" Dino Golzine, Ash, now at the rebellious age of seventeen, forsakes the kingdom held out by the devil who raised him. But the hideous secret that drove Ash's older brother mad in Vietnam has suddenly fallen into Papa's insatiably ambitious hands—and it's exactly the wrong time for Eiji Okamura, a pure-hearted young photographer from Japan, to make Ash Lynx's acquaintance...",
                2018,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg",
                "Action & Adventure,Drama,Mystery,Animation",
                90,
                "23m"
        ))
        tvShows.add(TVShowEntity(
                6,
                "Rent-a-Girlfriend",
                "In today’s Japan, \"rental\" services can deliver an afternoon with a \"friend,\" a \"parent,\" even a fake girlfriend! Kinoshita Kazuya is a 20-year-old failure of a college student. He managed to kiss his girlfriend once, but was dumped after a month. Completely spiteful, Kazuya gets just desperate enough to give it a try. But he quickly discovers how complicated it can be to \"rent\" an emotional connection… and his new \"girlfriend,\" Mizuhara Chizuru, who’s trying to keep her side hustle secret, will panic when she finds out her real life and Kazuya’s are intertwined in surprising ways! A reckless rom-com filled with love and excitement is about to begin!",
                2020,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/4rqyyM0R3a0EeSlEvdpxDKbjiKB.jpg",
                "Comedy,Animation",
                90,
                "24m"
        ))
        tvShows.add(TVShowEntity(
                7,
                "Golden Time",
                "Banri Tada is a freshman at a Tokyo law school. After an accident, he suffers severe memory loss. Despite the incident, he befriends fellow freshman, Mitsuo Yanagisawa, which leads him to the beautiful, yet obsessive, Kouko Kaga.",
                2013,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/qp4eHCZMR14dtubvzr67PZqH5fa.jpg",
                "Animation,Comedy,Drama",
                89,
                "24m"
        ))
        tvShows.add(TVShowEntity(
                8,
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                2016,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/phuYuzqWW9ru8EA3HVjE9W2Rr3M.jpg",
                "Action & Adventure,Animation,Comedy",
                89,
                "24m"
        ))
        tvShows.add(TVShowEntity(
                9,
                "Your Lie in April",
                "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
                2014,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/nksFLYTydth9OYVpMuMbtOBkvMO.jpg",
                "Animation,Comedy,Drama",
                89,
                "23m"
        ))
        tvShows.add(TVShowEntity(
                10,
                "DARLING in the FRANXX",
                "The story is set in the distant future. The land is ruined, and humanity establishes the mobile fort city Plantation. Pilots produced inside Plantation live in Mistilteinn, also know as the \"birdcage.\" Children live there knowing nothing of the outside world or the freedom of the sky. Their lives consist of battling to carry out missions. Their enemies are mysterious giant lifeforms known as Kyouryuu, and the children pilot robots called Franxx to face off against them. For the children, riding the Franxx proves their existence.\n" +
                        "\n" +
                        "A boy named Hiro is called Code:016, and he was once known as a prodigy. However, he has fallen behind, and his existence seems unnecessary. Not piloting a Franxx is the same as ceasing to exist. One day, a mysterious girl known as \"Zero Two\" appears before him. Two horns grow out of her head.",
                2018,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/pngI2TAtCVnGtuKbIcK8ZScAwZF.jpg",
                "Action & Adventure,Animation,Sci-Fi & Fantasy",
                89,
                "24m"
        ))
        tvShows.add(TVShowEntity(
                11,
                "My Love Story",
                "Takeo Godau is a giant guy with a giant heart. Too bad the girls don't want him! (They always go for his good-looking best friend, Makoto Sunakawa.) Used to being on the sidelines, Takeo simply stands tall and accepts his fate. But one day when he saves a girl named Rinko Yamato from a harasser on the train, his (love!) life suddenly takes an incredible turn! Takeo can hardly believe it when he crosses paths with Rinko again, and he finds himself falling in love with her... But with handsome Suna around, does Takeo even stand a chance?",
                2015,
                "https://image.tmdb.org/t/p/w300_and_h450_bestv2/vDTSx6BuelrdAO1CjVGs9MuUnMP.jpg",
                "Animation,Comedy",
                89,
                "24m"
        ))

        return tvShows
    }

    fun getTVShowById(tvShowId: Int): TVShowEntity {
        val tvShows = getTVShows()
        for(tvShow in tvShows){
            if(tvShow.id == tvShowId){
                return tvShow
            }
        }
        return TVShowEntity()
    }
}