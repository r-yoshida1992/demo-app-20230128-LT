import {Box} from "@mui/material";
import "../keyframes/Keyframes.css"

export const Loading = () => {
    return (
        <>
            <Box sx={{
                position: "fixed",
                width: "300px",
                height: "300px",
                top: "50%",
                left: "50%",
                transform: "translate(-50%, -50%)",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                backgroundColor: "transparent",
            }}>
                <Box sx={{
                    width: "150px",
                    height: "150px",
                    padding: "3px",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                    borderRadius: "50%",
                    background: "linear-gradient(0deg, rgba(63,249,220,0.1) 33%, rgba(63,249,220,1) 100%)",
                    animation: "spin .8s linear 0s infinite"
                }}>
                    <Box sx={{
                        width: "100%",
                        height: "100%",
                        backgroundColor: "#fff",
                        borderRadius: "50%",
                    }}>

                    </Box>
                </Box>
            </Box>
        </>
    )
}