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

import foundation.icon.icx.transport.jsonrpc.RpcItem;
import foundation.icon.icx.transport.jsonrpc.RpcObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static foundation.icon.icx.data.Converters.CONFIRMED_TRANSACTION;
import static foundation.icon.icx.data.Converters.CONFIRMED_LEADER_VOTE;
import static foundation.icon.icx.data.Converters.CONFIRMED_PREV_VOTE;

@SuppressWarnings("Duplicates")
public class BlockV3 implements Block {

    private RpcObject properties;

    BlockV3(RpcObject properties) {
        this.properties = properties;
    }

    @Override
    public RpcObject getProperties() {
        return properties;
    }

    @Override
    public Bytes getPrevBlockHash() {
        RpcItem item = properties.getItem("prev_block_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getMerkleTreeRootHash() {
        // Support Only version 2
        return null;
    }

    @Override
    public BigInteger getTimestamp() {
        RpcItem item = properties.getItem("time_stamp");
        return item != null ? item.asInteger() : null;
    }

    @Override
    public List<ConfirmedTransaction> getTransactions() {
        RpcItem item = properties.getItem("confirmed_transaction_list");
        List<ConfirmedTransaction> transactions = new ArrayList<>();
        if (item != null && getHeight().intValue() > 0) {
            for (RpcItem tx : item.asArray()) {
                transactions.add(CONFIRMED_TRANSACTION.convertTo(tx.asObject()));
            }
        }
        return transactions;
    }

    @Override
    public Bytes getBlockHash() {
        RpcItem item = properties.getItem("block_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public String getPeerId() {
        // Support Only version 2
        return null;
    }

    @Override
    public BigInteger getVersion() {
        RpcItem item = properties.getItem("version");
        return item != null ? item.asInteger() : null;
    }

    @Override
    public BigInteger getHeight() {
        RpcItem item = properties.getItem("height");
        return item != null ? item.asInteger() : null;
    }

    @Override
    public String getSignature() {
        RpcItem item = properties.getItem("signature");
        return item != null ? item.asString() : null;
    }

    @Override
    public Bytes getStateHash() {
        RpcItem item = properties.getItem("state_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getReceiptsHash() {
        RpcItem item = properties.getItem("receipt_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getRepsHash() {
        RpcItem item = properties.getItem("reps_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getNextRepsHash() {
        RpcItem item = properties.getItem("next_reps_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getLeaderVotesHash() {
        RpcItem item = properties.getItem("leader_votes_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Bytes getPrevVotesHash() {
        RpcItem item = properties.getItem("prev_votes_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public List<LeaderVote> getLeaderVotes() {
        RpcItem item = properties.getItem("leader_votes_list");
        List<LeaderVote> leaderVotes = new ArrayList<>();
        if (item != null && getHeight().intValue() > 0) {
            for (RpcItem tx : item.asArray()) {
                leaderVotes.add(CONFIRMED_LEADER_VOTE.convertTo(tx.asObject()));
            }
        }
        return leaderVotes;
    }

    @Override
    public List<PrevVote> getPrevVotes() {
        RpcItem item = properties.getItem("prev_votes_list");
        List<PrevVote> prevVotes = new ArrayList<>();
        if (item != null && getHeight().intValue() > 0) {
            for (RpcItem tx : item.asArray()) {
                prevVotes.add(CONFIRMED_PREV_VOTE.convertTo(tx.asObject()));
            }
        }
        return prevVotes;
    }

    @Override
    public Bytes getTransactionsHash() {
        RpcItem item = properties.getItem("transactions_hash");
        return item != null ? item.asBytes() : null;
    }

    @Override
    public Address getLeader() {
        RpcItem item = properties.getItem("leader");
        return item != null ? item.asAddress() : null;
    }

    @Override
    public Address getNextLeader() {
        RpcItem item = properties.getItem("next_leader");
        return item != null ? item.asAddress() : null;
    }

    @Override
    public String toString() {
        return "Block{" +
                "properties=" + properties +
                '}';
    }
}
