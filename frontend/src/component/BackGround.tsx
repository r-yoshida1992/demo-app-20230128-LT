import {Box, Typography} from "@mui/material";
import "../keyframes/Keyframes.css"

export const BackGround = () => {
    return (
    <>
        <Box sx={{
            position: "fixed",
            width: "100vw",
            height: "100vh",
            background: 'linear-gradient(-45deg, #EE7752, #E73C7E, #23A6D5, #23D5AB)',
            backgroundSize: '1500% 1500%',
            animation: 'Gradient 12s ease infinite',
            zIndex: "-1",
        }}/>
        <Typography
            color="#fff"
            position="fixed"
            top="50%"
            left="50%"
            fontWeight="bold"
            fontSize="18vw"
            whiteSpace="nowrap"
            sx={{
                userSelect: "none",
                transform: "translate(-50%, -50%)",
                opacity: "0.1",
            }}>Demo App</Typography>
    </>
)}