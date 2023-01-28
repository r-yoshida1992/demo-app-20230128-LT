import {SWRResponse} from "swr";
import React, {Dispatch, SetStateAction} from "react";

export const LoadImage = (props: { image: SWRResponse<any, any, any>, setValue: Dispatch<SetStateAction<String[]>> }) => {
    return (
        <>
            {props.image.isLoading ? <></> :
                <img alt="background" src={props.image.data?.base64}
                     style={{width: "100%", height: "100%", zIndex: "-1",}}/>}
        </>
    )
}
