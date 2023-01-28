export const fetcher = (url: string, params: object) => fetch(url, params).then((res) => res.json());
