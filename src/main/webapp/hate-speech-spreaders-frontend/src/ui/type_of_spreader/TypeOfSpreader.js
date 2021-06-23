import React, {useState, useEffect} from 'react'

import './TypeOfSpreader.css'

const TypeOfSpreader = props => {

    const {type} = props;

    const [typeOfSpreaderText, setTypeOfSpreaderText] = useState("");
    useEffect(() => {
        if(type === 'hate') {
            setTypeOfSpreaderText('Hate Speech Spreader !')
        } else if (type === 'normal'){
            setTypeOfSpreaderText('Not Hate Speech Spreader')
        } else {
            setTypeOfSpreaderText('Almost Hate Speech Spreader')
        }
    }, [type])


    return (
        <button className={`spreader ${type}`}
                     disabled={true}>{typeOfSpreaderText.toUpperCase()}
        </button>);

}

export default TypeOfSpreader;