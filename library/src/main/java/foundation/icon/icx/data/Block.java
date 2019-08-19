/*
 * Copyright 2018 ICON Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package foundation.icon.icx.data;

import foundation.icon.icx.transport.jsonrpc.RpcObject;

import java.math.BigInteger;
import java.util.List;


public interface Block {

    // Used in common Block
    RpcObject getProperties();

    List<ConfirmedTransaction> getTransactions();

    Bytes getPrevBlockHash();

    Bytes getBlockHash();

    BigInteger getTimestamp();

    BigInteger getVersion();

    BigInteger getHeight();

    String getSignature();

    // Used in Block V2
    Bytes getMerkleTreeRootHash();

    String getPeerId();


    // Used in Block V3
    Bytes getStateHash();

    Bytes getReceiptsHash();

    Bytes getRepsHash();

    Bytes getNextRepsHash();

    Bytes getLeaderVotesHash();

    Bytes getPrevVotesHash();

    List<LeaderVote> getLeaderVotes();

    List<PrevVote> getPrevVotes();

    Bytes getTransactionsHash();

    Address getLeader();

    Address getNextLeader();

}
