import * as React from 'react';
import {Grid,AppBar,Box,Toolbar,IconButton,Typography,Menu,Container,Avatar,Button,Tooltip,MenuItem} from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import Logo from '../../images/logo.png'
import Line from '../../images/line.png'
import data from './data.json'

const pages = ['Home', 'Notifications', 'Language', 'Points', 'About', 'Logout'];

console.log(data.firstName);

const ResponsiveAppBar = () => {
  const [anchorElNav, setAnchorElNav] = React.useState(null);

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  return (
    <AppBar position="static" style={{ background: '#EFE9F4' }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
            {/*Logo on a desktop page*/}
            <Typography
                variant="h6"
                noWrap
                component="div"
                sx={{ mr: 2, color: 'black', display: { xs: 'none', md: 'flex' } }}>
                <img src={Logo} />
                <img src={Line} />
            </Typography>

            <Typography
                variant="h6"
                sx={{color: 'black'}}>
                {data.firstName}
                {" "}
                {data.lastName}
            </Typography>
                
          {/*Displays the menu icon when the page is smaller or on a mobile*/}
          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}>
              <MenuIcon />
            </IconButton>

            {/*Menu itself*/} 
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}>
              {pages.map((page) => (
                <MenuItem key={page} onClick={handleCloseNavMenu}>
                  <Typography textAlign="">{page}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          
          {/*Logo on a responsive (usually mobile) page*/}
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <img src={Logo} />
          </Typography>
          
          {/*One button to show all the page names*/}
          <Box justifyContent="flex-end" sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={handleCloseNavMenu}
                sx={{ my: 2, color: 'black', display: 'block' }}>
                {page}
              </Button>
            ))}
          </Box>

        </Toolbar>
      </Container>
    </AppBar>
  );
};
export default ResponsiveAppBar;
