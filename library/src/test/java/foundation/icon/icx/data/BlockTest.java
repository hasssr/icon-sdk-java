package foundation.icon.icx.data;

import foundation.icon.icx.IconService;
import foundation.icon.icx.Provider;
import foundation.icon.icx.Request;
import foundation.icon.icx.transport.jsonrpc.RpcItem;
import foundation.icon.icx.transport.jsonrpc.RpcItemCreator;
import foundation.icon.icx.transport.jsonrpc.RpcObject;
import foundation.icon.icx.transport.jsonrpc.RpcValue;
import org.graalvm.compiler.hotspot.nodes.BeginLockScopeNode;
import org.junit.jupiter.api.Test;

import java.awt.color.ICC_ColorSpace;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static foundation.icon.icx.data.Converters.BLOCK_V3;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@SuppressWarnings("WeakerAccess")
public class BlockTest {

    @Test
    public void testBlockCreate(){

    }

    @Test
    public void testGetBlock(){

        Map<String, RpcItem> rpcMap;
        RpcItemCreator rpcItemCreator = new RpcItemCreator();
        RpcObject.Builder rpcBuilder = new RpcObject.Builder();
        rpcBuilder.put("version", RpcItemCreator.create(new BigInteger("2")));

        Converters.BLOCK_V3.convertTo(rpcBuilder.build());


    }

}
