import {BackGround} from "../component/BackGround";
import React, {useEffect, useState} from "react";
import useSWRImmutable from 'swr/immutable'
import {Info} from "../component/Info";
import {LoadImage} from "../component/LoadImage";
import {Grid} from "@mui/material";

export const Home = () => {



    const [infoList, setInfoList] = useState([] as String[]);
    const [showImage, setShowImage] = useState(false);
    const fetcher = (url: string, params: object) => fetch(url, params)
        .then((res) => res.json()).then((data) => {
            const newInfoList = infoList
            newInfoList.push(data.info)
            setInfoList(newInfoList)
            return data
        });

    const imageSmall = useSWRImmutable('https://localhost/api/image-small', fetcher)
    const imageLarge = useSWRImmutable('https://localhost/api/image-large', fetcher)
    useSWRImmutable('https://localhost/api/protocol', fetcher)

    return (
        <>
            <BackGround/>
            <Grid container sx={{overflow:"hidden" ,height:"100vh"}}>
                <Grid item xs={6}>
                    <LoadImage image={imageSmall} setValue={setInfoList}/>
                </Grid>
                <Grid item xs={6}>
                    <LoadImage image={imageLarge} setValue={setInfoList}/>
                </Grid>
            </Grid>
            {/*<Info infoList={infoList}/>*/}
        </>
    )
}