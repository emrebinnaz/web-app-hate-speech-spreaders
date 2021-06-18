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
    const [tweetOwners, setTweetOwners] = useState([]);

    useEffect(() => {

        async function fetchData() {
            const response = await getHomepage();
            const {hashtagDTOList, tweetOwnerDTOList, tweetDTOList} = response.data;

            setHashtags(hashtagDTOList);
            setTweetOwners(tweetOwnerDTOList);
            setTweets(tweetDTOList);
        }

        fetchData();
    },[])

    return(
        <main className={"homepage"}>
            <TweetStream tweets = {tweets}/>
            <Lists>
                <HashtagList hashtags = {hashtags}/>
                <MostInteractedUserList tweetOwners = {tweetOwners}/>
            </Lists>
        </main>
    );
}
export default Homepage;