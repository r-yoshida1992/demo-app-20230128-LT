import useSWR from "swr";

export const useLogsSWR= () => {
    return useSWR("/protocol");
}