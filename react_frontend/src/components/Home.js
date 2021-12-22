import React from "react";

// Components
import Header from "./Header";

// Hooks

// Images
import DormIcon from "../images/pageIcons/dorm.png";
import GymIcon from "../images/pageIcons/gym.png";
import MyProfileIcon from "../images/pageIcons/my_profile_icon.png";
import RoomHistoryIcon from "../images/pageIcons/room_history_icon.png";
import {Icon, PageButton, Wrapper, Content} from "./UpperRow/UpperRow.styles";
import MyCoursesIcon from "../images/pageIcons/my_courses_icon.png";
import HealthStatusIcon from "../images/pageIcons/health_status_logo.png"
import FormIcon from "../images/pageIcons/form_icon.png";


const Home = () => {
    return (
        <>
            <Header/>
            <Wrapper>
                <Content>
                    <PageButton>
                        <Icon src={MyCoursesIcon}/>
                        <div>
                            My Courses
                        </div>
                    </PageButton>
                    <PageButton>
                        <Icon src={HealthStatusIcon}/>
                        <div>
                            Health Status
                        </div>
                    </PageButton>
                    <PageButton>
                        <Icon src={FormIcon}/>
                        <div>
                            Daily Check Form
                        </div>
                    </PageButton>
                </Content>
                <Content>
                    <PageButton>
                        <Icon src={DormIcon}/>
                        <div>
                            Dorm Info
                        </div>
                    </PageButton>
                    <PageButton>
                        <Icon src={RoomHistoryIcon}/>
                        <div>
                            Room Info
                        </div>
                    </PageButton>
                    <PageButton>
                        <Icon src={MyProfileIcon}/>
                        <div>
                            My Profile
                        </div>
                    </PageButton>
                    <PageButton>
                        <Icon src={GymIcon}/>
                        <div>
                            Gym Info
                        </div>
                    </PageButton>
            </Content>
            </Wrapper>
        </>
    );
}

export default Home;