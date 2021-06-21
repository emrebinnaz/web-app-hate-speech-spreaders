import React, {useState, useEffect} from 'react'

import './homepage.css';
import TweetStream from "../../tweet/components/TweetStream";
import Lists from "../lists/Lists";
import HashtagList from "../../hashtag/components/HashtagList";
import MostInteractedUserList from "../../tweetowner/components/MostInteractedUserList";
import {getHomepage} from "../../requests/HomepageRequests";
import {getTweetsOfHashtag} from "../../requests/TweetRequests";

const Homepage = () => {

    const [tweets, setTweets] = useState([]);
    const [hashtags, setHashtags] = useState([]);
    const [tweetOwners, setTweetOwners] = useState([]);
    const [streamHeaderText, setStreamHeaderText] = useState('Stream')

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

    const onClickHashtagHandler = async (hashtagId, hashtagName) => {

        const response = await getTweetsOfHashtag(hashtagId);
        setTweets(response.data);
        setStreamHeaderText("Tweets about " + hashtagName);
    }

    return(
        <main className={"homepage"}>
            <TweetStream tweets = {tweets}
                         streamHeaderText = {streamHeaderText}/>
            <Lists>
                <HashtagList hashtags = {hashtags} onClickHandler ={onClickHashtagHandler}/>
                <MostInteractedUserList tweetOwners = {tweetOwners}/>
            </Lists>
        </main>
    );
}
export default Homepage;