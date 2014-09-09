package com.newlastfm.gson;

import com.google.gson.Gson;
import com.newlastfm.model.RecommendedArtists;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 9/9/14.
 */
public class GSONRecommendedArtistsTest {

    String jsonString = "{\n" +
            "    \"recommendations\": {\n" +
            "        \"artist\": [\n" +
            "            {\n" +
            "                \"name\": \"Dead by April\",\n" +
            "                \"mbid\": \"5578d1ad-02db-4b17-ada1-32d1aa4efd49\",\n" +
            "                \"url\": \"http://www.last.fm/music/Dead+by+April\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/28210655.png\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/28210655.png\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/28210655.png\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/28210655.png\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/_/28210655/Dead+by+April.png\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Sonic Syndicate\",\n" +
            "                            \"mbid\": \"10a402b7-0e50-4479-b007-9cfdd5eaa287\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Sonic+Syndicate\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/98508579.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/98508579.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/98508579.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/98508579.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/98508579/Sonic+Syndicate++2014.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Hollywood Undead\",\n" +
            "                            \"mbid\": \"321fdfbb-426b-43f7-8295-fa9aca6348d9\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Hollywood+Undead\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/58156137.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/58156137.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/58156137.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/58156137.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/58156137/Hollywood+Undead+HUATPROMO3.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"Emigrate\",\n" +
            "                \"mbid\": \"1945e27b-5b00-4dc7-bd0a-7c653cb68f45\",\n" +
            "                \"url\": \"http://www.last.fm/music/Emigrate\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/2148989.jpg\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/2148989.jpg\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/2148989.jpg\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/2148989.jpg\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/_/2148989/Emigrate.jpg\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Oomph!\",\n" +
            "                            \"mbid\": \"174e4bad-247f-4a6c-95e0-09891a7ffb75\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Oomph!\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/351912.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/351912.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/351912.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/351912.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/351912/Oomph.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Rammstein\",\n" +
            "                            \"mbid\": \"b2d122f9-eadb-4930-a196-8f221eeb0c66\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Rammstein\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/2385014.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/2385014.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/2385014.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/2385014.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/2385014/Rammstein+ramm_ruins.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"Atreyu\",\n" +
            "                \"mbid\": \"17e137fb-59e5-4fd7-af48-afc34995396c\",\n" +
            "                \"url\": \"http://www.last.fm/music/Atreyu\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/41551041.jpg\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/41551041.jpg\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/41551041.jpg\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/41551041.jpg\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/500/41551041/Atreyu.jpg\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Sonic Syndicate\",\n" +
            "                            \"mbid\": \"10a402b7-0e50-4479-b007-9cfdd5eaa287\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Sonic+Syndicate\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/98508579.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/98508579.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/98508579.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/98508579.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/98508579/Sonic+Syndicate++2014.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Trivium\",\n" +
            "                            \"mbid\": \"1f5ff245-2837-4d4a-a609-e93e544478c3\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Trivium\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/38425215.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/38425215.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/38425215.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/38425215.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/38425215/Trivium+PNG.png\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"Amaranthe\",\n" +
            "                \"mbid\": \"eb380962-99bb-46c0-af40-1c7790a7822a\",\n" +
            "                \"url\": \"http://www.last.fm/music/Amaranthe\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/62583953.png\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/62583953.png\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/62583953.png\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/62583953.png\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/500/62583953/Amaranthe+PNG.png\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Sonic Syndicate\",\n" +
            "                            \"mbid\": \"10a402b7-0e50-4479-b007-9cfdd5eaa287\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Sonic+Syndicate\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/98508579.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/98508579.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/98508579.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/98508579.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/98508579/Sonic+Syndicate++2014.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Within Temptation\",\n" +
            "                            \"mbid\": \"eace2373-31c8-4aba-9a5c-7bce22dd140a\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Within+Temptation\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/45505139.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/45505139.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/45505139.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/45505139.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/45505139/Within+Temptation++900x900+PNG.png\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"Fort Minor\",\n" +
            "                \"mbid\": \"e1564e98-978b-4947-8698-f6fd6f8b0181\",\n" +
            "                \"url\": \"http://www.last.fm/music/Fort+Minor\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/156004.jpg\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/156004.jpg\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/156004.jpg\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/156004.jpg\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/500/156004/Fort+Minor.jpg\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Linkin Park\",\n" +
            "                            \"mbid\": \"f59c5520-5f46-4d2c-b2c4-822eabf53419\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Linkin+Park\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/7591.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/7591.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/7591.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/7591.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/7591/Linkin+Park.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Hollywood Undead\",\n" +
            "                            \"mbid\": \"321fdfbb-426b-43f7-8295-fa9aca6348d9\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Hollywood+Undead\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/58156137.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/58156137.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/58156137.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/58156137.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/58156137/Hollywood+Undead+HUATPROMO3.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        ],\n" +
            "        \"@attr\": {\n" +
            "            \"user\": \"deezzel07\",\n" +
            "            \"page\": \"1\",\n" +
            "            \"perPage\": \"5\",\n" +
            "            \"totalPages\": \"50\",\n" +
            "            \"total\": \"250\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Test
    public void test() {
        Gson gson = new Gson();
        RecommendedArtists recommendedArtists = gson.fromJson(jsonString, RecommendedArtists.class);
        assertNotNull(recommendedArtists.getRecommendations().getArtist());
    }
}
