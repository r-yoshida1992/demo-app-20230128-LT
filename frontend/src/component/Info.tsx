import {Box, Typography} from "@mui/material";
import React from "react";

export const Info = (props:{infoList:String[]}) => (
    <Box
        sx={{
            position: "fixed",
            backgroundColor: "#000",
            width: "90vw",
            height: "30vh",
            bottom: "5vw",
            left: "5vw",
            borderRadius: "8px",
            border: "solid 1px #bbb",
            opacity: 0.6
        }}>
        <Box sx={{
            backgroundColor: "#333",
            width: "90vw",
            height: "3vh",
            borderTopLeftRadius: "8px",
            borderTopRightRadius: "8px",
            textAlign: "left",
        }}>
            <Typography pl={2} fontSize={20} fontWeight="bold" color="#fff">Info</Typography>
        </Box>
        <Box p={2} sx={{
            height: "23.7vh",
            overflowX: "hidden",
            overflowY: "scroll",
            "::-webkit-scrollbar-track": {
                borderRadius: "4px",
                backgroundColor: "#000",
            },
            "::-webkit-scrollbar": {
                width: "8px",
                backgroundColor: "#000",
            },
            "::-webkit-scrollbar-thumb": {
                borderRadius: "4px",
                backgroundColor: "#fff",
            },
        }}>
            {props.infoList.map((info, index) => (<Box key={index}>
                <Typography color="#fff" fontSize={20} fontWeight="bold" whiteSpace="pre-wrap">{info}</Typography></Box>))}
       </Box>
    </Box>
)