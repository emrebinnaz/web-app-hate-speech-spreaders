import axios from 'axios';
import {GET_HOMEPAGE_URL} from "./BackendUrls";

export const getHomepage = async () => {

    return await axios.get(GET_HOMEPAGE_URL, {

    }).catch(err => {
        return err.response;
    })
}