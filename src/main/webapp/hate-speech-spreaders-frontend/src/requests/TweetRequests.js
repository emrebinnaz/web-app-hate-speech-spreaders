import axios from 'axios';
import {GET_TWEETS_OF_HASHTAG_URL} from "./BackendUrls";

export const getTweetsOfHashtag = async (hashtagId) => {

    const request = {hashtagId};

    return await axios.post(GET_TWEETS_OF_HASHTAG_URL, request)
        .catch(err => {
            return err.response;
    })
}