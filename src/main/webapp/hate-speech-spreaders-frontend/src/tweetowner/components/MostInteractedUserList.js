import React from 'react'

import './MostInteractedUserList.css'
import Card from "../../ui/card/Card";
import MostInteractedUser from "./MostInteractedUser";

const MostInteractedUserList = props => {

    const {tweetOwners} = props;

    return(
        <Card headerText = {"Most Interacted Users"}>
            {
                tweetOwners.map((tweetOwner, index) => (
                    <MostInteractedUser key = {index}
                             id = {tweetOwner.id}
                             name = {tweetOwner.name}
                             handler = {props.onClickHandler}
                             username = {tweetOwner.username}
                             imageUrl = {tweetOwner.imageUrl}/>
                ))
            }
        </Card>
    );
}
export default MostInteractedUserList;