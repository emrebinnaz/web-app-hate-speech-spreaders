import {React} from 'react';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHome } from '@fortawesome/free-solid-svg-icons'

import './HomepageIcon.css'

const HomepageIcon = () =>{

    return(
        <FontAwesomeIcon icon={faHome}
                         className={"homepage-icon"}/>
    )
}

export default HomepageIcon;