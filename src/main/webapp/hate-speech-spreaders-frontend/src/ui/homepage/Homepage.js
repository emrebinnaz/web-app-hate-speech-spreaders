import React, {useState, useEffect} from 'react'

import './homepage.css';
import TweetStream from "../../tweet/components/TweetStream";
import Lists from "../lists/Lists";
import HashtagList from "../../hashtag/components/HashtagList";
import MostInteractedUserList from "../../tweetowner/components/MostInteractedUserList";
import {getHomepage} from "../../requests/HomepageRequests";
import {getTweetsOfHashtag} from "../../requests/TweetRequests";
import {getTweetsOfUser} from "../../requests/TweetOwnerRequests";
import TweetOwnerProfileInfo from "../../tweetowner/components/TweetOwnerProfileInfo";
import {scrollToTop} from "../../util/BrowserUtil";
import ClipLoader from "react-spinners/ClipLoader";

const Homepage = () => {

    const [isLoading, setLoading] = useState(false);
    let [color, setColor] = useState("#ffffff");

    const [tweets, setTweets] = useState([]);
    const [hashtags, setHashtags] = useState([]);
    const [tweetOwners, setTweetOwners] = useState([]);

    const [streamHeaderText, setStreamHeaderText] = useState('Stream')

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
            setLoading(false);
        }

        fetchData();

    },[])

    const onClickHashtagHandler = async (hashtagId, hashtagName) => {

        const response = await getTweetsOfHashtag(hashtagId);
        setTweets(response.data);
        setIsOwnerClicked(false)
        setStreamHeaderText("Tweets about " + hashtagName);

    }

    const onClickMostInteractedUserHandler = async (userId, username) => {
        const response = await getTweetsOfUser(username);

        setTweets(response.data.tweetDTOList)
        setOwnerInfo(response.data.tweetOwnerDTO)
        setIsOwnerClicked(true)
        setStreamHeaderText("Tweets of " + username);

        scrollToTop()
    }

    return(
        <main className={"homepage"}>
            <div>
                {isOwnerClicked ? <TweetOwnerProfileInfo ownerInfo = {ownerInfo}/> : null}
                <TweetStream tweets = {tweets}
                             streamHeaderText = {streamHeaderText}/>
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