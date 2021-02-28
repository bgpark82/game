import React from 'react';
import '../style/css/reset.css';
import '../style/css/custom.css';
import Head from "next/head";

const App = ({ Component, pageProps }) => (
    <>
        <Head >
            <title>Time's Up!</title>
            <link href='https://spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css' />
        </Head>
        <Component {...pageProps} />
    </>
);

export default App

