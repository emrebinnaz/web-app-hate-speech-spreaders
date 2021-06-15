import axios from 'axios';

export const getHomepage = async () => {

    return await axios.get('/getHomepage', {

    }).catch(err => {
        return err.response;
    })
}