import {React} from 'react';
import './Navigation.css'
import {Link, useHistory} from "react-router-dom";
import HomepageIcon from "../homepage/HomepageIcon";
import {HOMEPAGE_URL} from "../../constants/Urls";

const Navigation = () =>{

    let history = useHistory();

    const goToHomepage = (e) => {

        e.preventDefault();
        history.push(HOMEPAGE_URL)
    }

    return(
        <div className={"navigation"}>
            <Link>
                <h2 className = "navigation-website-name">Site İsmi </h2>
            </Link>
            <Link onClick = {(e) => goToHomepage(e)}>
                <HomepageIcon/>
            </Link>
        </div>
    );
}

export default Navigation;