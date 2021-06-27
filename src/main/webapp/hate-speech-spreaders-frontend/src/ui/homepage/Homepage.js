import React, {useState, useEffect} from 'react'

import './homepage.css';
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css";
import Loader from "react-loader-spinner";
import TweetStream from "../../tweet/components/TweetStream";
import Lists from "../lists/Lists";
import HashtagList from "../../hashtag/components/HashtagList";
import MostInteractedUserList from "../../tweetowner/components/MostInteractedUserList";
import {getHomepage} from "../../requests/HomepageRequests";
import {getTweetsOfHashtag} from "../../requests/TweetRequests";
import {getTweetsOfUser} from "../../requests/TweetOwnerRequests";
import TweetOwnerProfileInfo from "../../tweetowner/components/TweetOwnerProfileInfo";
import {scrollToTop} from "../../util/BrowserUtil";
import {useHistory} from "react-router-dom";

const Homepage = () => {

    const [isLoading, setLoading] = useState(true);

    const [tweets, setTweets] = useState([]);
    const [streamTweets, setStreamTweets] = useState([]);
    const [hashtags, setHashtags] = useState([]);
    const [tweetOwners, setTweetOwners] = useState([]);

    const [streamHeaderText, setStreamHeaderText] = useState('Stream')

    const [isHashtagClicked, setIsHashtagClicked] = useState(false);
    const [isOwnerClicked, setIsOwnerClicked] = useState(false)
    const [ownerInfo, setOwnerInfo] = useState(null);

    useEffect(() => {
        setLoading(true);
        async function fetchData() {
            const response = await getHomepage();
            const {hashtagDTOList, tweetOwnerDTOList, tweetDTOList} = response.data;
            setHashtags(hashtagDTOList);
            setTweetOwners(tweetOwnerDTOList);
            setTweets(tweetDTOList);
            setStreamTweets(tweetDTOList);
            setLoading(false);
        }

        fetchData();

    },[])

    const onClickHashtagHandler = async (hashtagId, hashtagName) => {

        const response = await getTweetsOfHashtag(hashtagId);

        setTweets(response.data);

        setIsOwnerClicked(false);
        setIsHashtagClicked(true);
        setStreamHeaderText("Tweets about " + hashtagName);


    }

    const onClickMostInteractedUserHandler = async (userId, username) => {
        const response = await getTweetsOfUser(username);

        setTweets(response.data.tweetDTOList)
        setOwnerInfo(response.data.tweetOwnerDTO)

        setIsOwnerClicked(true)
        setIsHashtagClicked(false)
        setStreamHeaderText("Tweets of " + username);

        scrollToTop()
    }

    const onClickShowStreamTweetsHandler = () => {

        setTweets(streamTweets)
        setStreamHeaderText("Stream")
        setIsHashtagClicked(false)
        setIsOwnerClicked(false)
    }


    if(isLoading) {
        return( <Loader
                type="ThreeDots"
                color="#1da1f2"
                height={100}
                width={100}
                style = {{position: 'absolute', top: '50%', left: '50%'}}
        />);
    }

    return(
        <main className={"homepage"}>
            <div>
                {isOwnerClicked ? <TweetOwnerProfileInfo ownerInfo = {ownerInfo}/> : null}
                <TweetStream tweets = {tweets}
                             onClickShowStreamTweetsHandler = {onClickShowStreamTweetsHandler}
                             streamHeaderText = {streamHeaderText}
                             isStreamTweetsShown = {isHashtagClicked || isOwnerClicked}/>
            </div>
            <Lists>
                <HashtagList hashtags = {hashtags}
                             onClickHandler ={onClickHashtagHandler}/>
                <MostInteractedUserList tweetOwners = {tweetOwners}
                                        onClickHandler = {onClickMostInteractedUserHandler}/>
            </Lists>
        </main>
    );
}
export default Homepage;