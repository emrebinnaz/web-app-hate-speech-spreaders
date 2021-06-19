import React from 'react'

import './HashtagList.css';
import Card from "../../ui/card/Card";
import Hashtag from "./Hashtag";

const HashtagList = props => {

    const {hashtags} = props;

    return(
        <Card headerText = {"Trending Hashtags"}>
            {
                hashtags.map((hashtag, index) => (
                    <Hashtag key = {index}
                             id = {hashtag.id}
                             name = {hashtag.name}/>
                ))
            }
        </Card>
    );
}
export default HashtagList;