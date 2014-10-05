package com.newlastfm.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newlastfm.model.RecommendedArtists;
import com.newlastfm.model.gson.RecommendedArtistsDeserializer;

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
            "                \"name\": \"Tarja\",\n" +
            "                \"mbid\": \"a1e626f0-ed1f-444a-af2e-86aeae6651e4\",\n" +
            "                \"url\": \"http://www.last.fm/music/Tarja\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/70893024.png\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/70893024.png\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/70893024.png\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/70893024.png\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/_/70893024/Tarja+TH+PNGHQ.png\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Nightwish\",\n" +
            "                            \"mbid\": \"00a9f935-ba93-4fc8-a33a-993abe9c936b\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Nightwish\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/46142261.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/46142261.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/46142261.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/46142261.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/46142261/Nightwish++930s.png\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Delain\",\n" +
            "                            \"mbid\": \"3b0e8f01-3fd9-4104-9532-1e4b526ce562\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Delain\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/98332301.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/98332301.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/98332301.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/98332301.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/98332301/Delain+THE+HUMAN+CONTRADICTION.png\",\n" +
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
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/3071876.jpg\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/3071876.jpg\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/3071876.jpg\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/3071876.jpg\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/_/3071876/Emigrate+rich124.jpg\",\n" +
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
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/10160771.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/10160771.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/10160771.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/10160771.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/10160771/Oomph++Monster2.jpg\",\n" +
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
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/2384765.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/2384765.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/2384765.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/2384765.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/2384765/Rammstein+bm.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"Epica\",\n" +
            "                \"mbid\": \"21985b14-1b0d-44fe-b357-310b29bba510\",\n" +
            "                \"url\": \"http://www.last.fm/music/Epica\",\n" +
            "                \"streamable\": \"0\",\n" +
            "                \"image\": [\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/97476819.png\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/97476819.png\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/97476819.png\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/97476819.png\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/500/97476819/Epica+The+Quantum+Enigma+2014++PNG.png\",\n" +
            "                        \"size\": \"mega\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"context\": {\n" +
            "                    \"artist\": [\n" +
            "                        {\n" +
            "                            \"name\": \"Nightwish\",\n" +
            "                            \"mbid\": \"00a9f935-ba93-4fc8-a33a-993abe9c936b\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Nightwish\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/46142261.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/46142261.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/46142261.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/46142261.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/46142261/Nightwish++930s.png\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Delain\",\n" +
            "                            \"mbid\": \"3b0e8f01-3fd9-4104-9532-1e4b526ce562\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Delain\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/98332301.png\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/98332301.png\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/98332301.png\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/98332301.png\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/98332301/Delain+THE+HUMAN+CONTRADICTION.png\",\n" +
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
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/34/173696.jpg\",\n" +
            "                        \"size\": \"small\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/64/173696.jpg\",\n" +
            "                        \"size\": \"medium\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/126/173696.jpg\",\n" +
            "                        \"size\": \"large\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/252/173696.jpg\",\n" +
            "                        \"size\": \"extralarge\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"#text\": \"http://userserve-ak.last.fm/serve/500/173696/Fort+Minor.jpg\",\n" +
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
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/181147.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/181147.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/181147.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/181147.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/500/181147/Linkin+Park.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"name\": \"Limp Bizkit\",\n" +
            "                            \"mbid\": \"8f9d6bb2-dba4-4cca-9967-cc02b9f4820c\",\n" +
            "                            \"url\": \"http://www.last.fm/music/Limp+Bizkit\",\n" +
            "                            \"streamable\": \"0\",\n" +
            "                            \"image\": [\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/34/243581.jpg\",\n" +
            "                                    \"size\": \"small\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/64/243581.jpg\",\n" +
            "                                    \"size\": \"medium\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/126/243581.jpg\",\n" +
            "                                    \"size\": \"large\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/252/243581.jpg\",\n" +
            "                                    \"size\": \"extralarge\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"#text\": \"http://userserve-ak.last.fm/serve/_/243581/Limp+Bizkit.jpg\",\n" +
            "                                    \"size\": \"mega\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            },\n" +
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
            "                    \"artist\": \n" +
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
            "                        }\n" +
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
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RecommendedArtists.class, new RecommendedArtistsDeserializer());
        Gson gson = gsonBuilder.create();
        RecommendedArtists recommendedArtists = gson.fromJson(jsonString, RecommendedArtists.class);
        assertNotNull(recommendedArtists.getRecommendations().getArtist());
    }
}
