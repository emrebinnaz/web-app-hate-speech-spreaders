import React from 'react'


const Avatar = props => {

    return (
        <img src={props.imageUrl}
             className={props.className}
             alt = "avatar"/>
    );
}
export default Avatar;