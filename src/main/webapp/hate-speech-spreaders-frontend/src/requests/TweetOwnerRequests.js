import axios from 'axios';
import {GET_TWEETS_OF_OWNER_URL} from "./BackendUrls";

export const getTweetsOfUser = async (username) => {

    const request = {username};

    return await axios.post(GET_TWEETS_OF_OWNER_URL, request)
        .catch(err => {
            return err.response;
        })
}