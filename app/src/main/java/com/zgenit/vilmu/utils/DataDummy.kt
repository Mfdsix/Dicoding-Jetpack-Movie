package com.zgenit.vilmu.utils

import com.zgenit.vilmu.data.source.local.entity.MovieEntity
import com.zgenit.vilmu.data.source.local.entity.TVShowEntity

//
// Created by Mfdsix on 28/11/2020.
// Copyright (c) 2020 Zgenit. All rights reserved.
//

object DataDummy {

    fun getMovies(): List<MovieEntity>{
        val movies = arrayListOf<MovieEntity>()

        movies.add(MovieEntity(
                761053,
                "Gabriel's Inferno Part III",
                "The final part of the film adaption of the erotic romance novel Gabriel's Inferno written by an anonymous Canadian author under the pen name Sylvain Reynard.",
                Constant.IMG_BASE_URL + "/qtX2Fg9MTmrbgN1UUvGoCsImTM8.jpg",
                9.3,
                "2020-11-19",
                "en",
        ))
        movies.add(MovieEntity(
                724089,
                "Gabriel's Inferno Part II",
                "Professor Gabriel Emerson finally learns the truth about Julia Mitchell's identity, but his realization comes a moment too late. Julia is done waiting for the well-respected Dante specialist to remember her and wants nothing more to do with him. Can Gabriel win back her heart before she finds love in another's arms?",
                Constant.IMG_BASE_URL + "/pci1ArYW7oJ2eyTo2NMYEKHHiCP.jpg",
                8.9,
                "2020-07-31",
                "en",
        ))
        movies.add(MovieEntity(
                696374,
                "Gabriel's Inferno",
                "An intriguing and sinful exploration of seduction, forbidden love, and redemption, Gabriel's Inferno is a captivating and wildly passionate tale of one man's escape from his own personal hell as he tries to earn the impossible--forgiveness and love.",
                Constant.IMG_BASE_URL + "/oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg",
                8.8,
                "2020-05-29",
                "en",
        ))
        movies.add(MovieEntity(
                278,
                "The Shawshank Redemption",
                "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                Constant.IMG_BASE_URL + "/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg",
                8.7,
                "1994-09-23",
                "en",
        ))
        movies.add(MovieEntity(
                238,
                "The Godfather",
                "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
                Constant.IMG_BASE_URL + "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                8.7,
                "1972-03-14",
                "en",
        ))
        movies.add(MovieEntity(
                19404,
                "Dilwale Dulhania Le Jayenge",
                "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
                Constant.IMG_BASE_URL + "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
                8.7,
                "1995-10-20",
                "en",
        ))
        movies.add(MovieEntity(
                644479,
                "Dedicated to my ex",
                "The film tells the story of Ariel, a 21-year-old who decides to form a rock band to compete for a prize of ten thousand dollars in a musical band contest, this as a last option when trying to get money to save their relationship and reunite with his ex-girlfriend, which breaks due to the trip she must make to Finland for an internship. Ariel with her friend Ortega, decides to make a casting to find the other members of the band, although they do not know nothing about music, thus forming a band with members that have diverse and opposite personalities.",
                Constant.IMG_BASE_URL + "/riAooJrFvVhotyaOgoI0WR7okSe.jpg",
                8.7,
                "2019-11-01",
                "en",
        ))
        movies.add(MovieEntity(
                424,
                "Schindler's List",
                "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
                Constant.IMG_BASE_URL + "/c8Ass7acuOe4za6DhSattE359gr.jpg",
                8.6,
                "1993-11-30",
                "en",
        ))
        movies.add(MovieEntity(
                372058,
                "Your Name.",
                "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
                Constant.IMG_BASE_URL + "/q719jXXEzOoYaps6babgKnONONX.jpg",
                8.6,
                "2016-08-26",
                "ja",
        ))
        movies.add(MovieEntity(
                240,
                "The Godfather: Part II",
                "In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.",
                Constant.IMG_BASE_URL + "/hek3koDUyRQk7FIhPXsa6mT2Zc3.jpg",
                8.6,
                "1974-12-20",
                "en",
        ))
        movies.add(MovieEntity(
                129,
                "Spirited Away",
                "A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.",
                Constant.IMG_BASE_URL + "/eO4NHOsitcVpRw0kolJRLxXdxa2.jpg",
                8.5,
                "2001-07-20",
                "ja",
        ))

        return movies
    }

    fun getTVShows(): List<TVShowEntity>{
        val tvShows = arrayListOf<TVShowEntity>()

        tvShows.add(TVShowEntity(
                100,
                "I Am Not an Animal",
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                Constant.IMG_BASE_URL + "/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
                9.4,
                "2004-05-10",
                "en"
        ))
        tvShows.add(TVShowEntity(
                88040,
                "Given",
                "The played chord made the rusty air and both our eardrums vibrate smoothly. From that moment... our music was born.",
                Constant.IMG_BASE_URL + "/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
                9.2,
                "2019-07-11",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                83097,
                "The Promised Neverland",
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n" +
                        "\n" +
                        "However, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                Constant.IMG_BASE_URL + "/yxdeII5tI8qqiERcMxjW9DfB6Gz.jpg",
                9.1,
                "2019-01-09",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                83095,
                "The Rising of the Shield Hero",
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                Constant.IMG_BASE_URL + "/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
                9.1,
                "2019-01-09",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                96316,
                "Rent-a-Girlfriend",
                "In today’s Japan, \"rental\" services can deliver an afternoon with a \"friend,\" a \"parent,\" even a fake girlfriend! Kinoshita Kazuya is a 20-year-old failure of a college student. He managed to kiss his girlfriend once, but was dumped after a month.  Completely spiteful, Kazuya gets just desperate enough to give it a try. But he quickly discovers how complicated it can be to \"rent\" an emotional connection… and his new \"girlfriend,\" Mizuhara Chizuru, who’s trying to keep her side hustle secret, will panic when she finds out her real life and Kazuya’s are intertwined in surprising ways! A reckless rom-com filled with love and excitement is about to begin!",
                Constant.IMG_BASE_URL + "/4rqyyM0R3a0EeSlEvdpxDKbjiKB.jpg",
                9.0,
                "2020-07-11",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                93019,
                "ORESUKI: Are you the only one who loves me?",
                "Kisaragi Amatsuyu is invited out alone by the cool beauty upperclassman Cosmos and his childhood friend Himawari. Expecting to hear their confessions, he triumphantly goes to meet each of them in turn. But Cosmos and Himawari both instead confess to Amatsuyu that they like his friend. Amatsuyu fights this lonely battle, but there is another girl who is looking at him. She is a gloomy girl with glasses and braids. Amatsuyu finds that he hates her, because she's always turning her sharp tongue only on him and finding enjoyment in his troubles. But it turns out that she's the only one who actually does like him.",
                Constant.IMG_BASE_URL + "/4MojZik5N62IShd2BFVEHyaRBLP.jpg",
                9.0,
                "2019-10-03",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                80564,
                "Banana Fish",
                "Nature made Ash Lynx beautiful; nurture made him a cold ruthless killer. A runaway brought up as the adopted heir and sex toy of \"Papa\" Dino Golzine, Ash, now at the rebellious age of seventeen, forsakes the kingdom held out by the devil who raised him. But the hideous secret that drove Ash's older brother mad in Vietnam has suddenly fallen into Papa's insatiably ambitious hands—and it's exactly the wrong time for Eiji Okamura, a pure-hearted young photographer from Japan, to make Ash Lynx's acquaintance...",
                Constant.IMG_BASE_URL + "/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg",
                8.9,
                "2018-07-06",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                65930,
                "My Hero Academia",
                "In a world where eighty percent of the population has some kind of super-powered Quirk, Izuku was unlucky enough to be born completely normal. But that won’t stop him from enrolling in a prestigious hero academy. Now, he’ll get his first taste of brutal rivalry from other schools as he braves the cutthroat, no-holds-barred provisional license exam.",
                Constant.IMG_BASE_URL + "/phuYuzqWW9ru8EA3HVjE9W2Rr3M.jpg",
                8.9,
                "2016-04-03",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                87432,
                "We Never Learn: BOKUBEN",
                "Nariyuki Yuiga is in his last and most painful year of high school. In order to gain the “special VIP recommendation” which would grant him a full scholarship to college, he must now tutor his classmates as they struggle to prepare for entrance exams.\n" +
                        "\n" +
                        "Among his pupils are “the sleeping beauty of the literary forest,” Fumino Furuhashi, and “the Thumbelina supercomputer,” Rizu Ogata–two of the most beautiful super-geniuses at the school! While these two were thought to be academically flawless, it turns out that they’re completely clueless outside of their pet subjects…!?\n" +
                        "\n" +
                        "As Nariyuki’s life is turned upside down by these quirky girls who just never learn, he must do everything he can to get them accepted into college! The stage is set for this romantic comedy featuring prodigies who never learn when it comes to studying and love!",
                Constant.IMG_BASE_URL + "/fG3VClLXTvE6MpR0x8fv2q4cpGD.jpg",
                8.9,
                "2019-04-07",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                67389,
                "Golden Time",
                "Banri Tada is a freshman at a Tokyo law school. After an accident, he suffers severe memory loss. Despite the incident, he befriends fellow freshman, Mitsuo Yanagisawa, which leads him to the beautiful, yet obsessive, Kouko Kaga.",
                Constant.IMG_BASE_URL + "/qp4eHCZMR14dtubvzr67PZqH5fa.jpg",
                8.9,
                "2013-10-04",
                "ja"
        ))
        tvShows.add(TVShowEntity(
                76121,
                "DARLING in the FRANXX",
                "The story is set in the distant future. The land is ruined, and humanity establishes the mobile fort city Plantation. Pilots produced inside Plantation live in Mistilteinn, also know as the \"birdcage.\" Children live there knowing nothing of the outside world or the freedom of the sky. Their lives consist of battling to carry out missions. Their enemies are mysterious giant lifeforms known as Kyouryuu, and the children pilot robots called Franxx to face off against them. For the children, riding the Franxx proves their existence.\n" +
                        "\n" +
                        "A boy named Hiro is called Code:016, and he was once known as a prodigy. However, he has fallen behind, and his existence seems unnecessary. Not piloting a Franxx is the same as ceasing to exist. One day, a mysterious girl known as \"Zero Two\" appears before him. Two horns grow out of her head.",
                Constant.IMG_BASE_URL + "/pngI2TAtCVnGtuKbIcK8ZScAwZF.jpg",
                8.9,
                "2018-01-13",
                "ja"
        ))

        return tvShows
    }

    fun getMovieById(movieId: Int): MovieEntity? {
        val movies = getMovies()

        movies.forEach {
            if(movieId == it.id){
                return it
            }
        }

        return null
    }

    fun getTVShowById(tvShowId: Int): TVShowEntity? {
        val tvShows = getTVShows()

        tvShows.forEach {
            if(tvShowId == it.id){
                return it
            }
        }

        return null
    }
}