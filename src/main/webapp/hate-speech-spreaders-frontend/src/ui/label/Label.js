import React from 'react'


import './label.css'

const Label = props => {

    const {label} = props;

    return(
        <button className={`label ${label}`}
                disabled={true}>{label.toUpperCase()}
        </button>
    );
}

export default Label;