import React, {useState, useEffect} from 'react'

import './homepage.css';
import TweetStream from "../tweet/components/TweetStream";
import Lists from "./Lists";
import HashtagList from "../hashtag/components/HashtagList";
import MostInteractedUserList from "../tweetowner/components/MostInteractedUserList";
import {getHomepage} from "../requests/HomepageRequests";
const Homepage = () => {

    const [tweets, setTweets] = useState([]);
    const [hashtags, setHashtags] = useState([]);

    useEffect(async () => {
        const response = await getHomepage();
        const {hashtagDTOList, tweetDTOList} = response.data;

        setHashtags(hashtagDTOList);
        setTweets(tweetDTOList);

    },[])

    return(
        <main className={"homepage"}>
            <TweetStream tweets = {tweets}/>
            <Lists>
                <HashtagList hashtags = {hashtags}/>
                <MostInteractedUserList/>
            </Lists>
        </main>
    );
}
export default Homepage;