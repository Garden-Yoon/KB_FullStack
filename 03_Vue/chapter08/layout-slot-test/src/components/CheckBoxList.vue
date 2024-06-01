<template>
  <div v-for="item in items" :key="item.id">
    <!-- icon slot에 checked 값을 담아서 부모에게 보냄 -->
    <slot name="icon" :checked="item.checked"></slot>
    <!-- 부모의 check-change 이벤트에 현재 체크박스 체크 여부 전송 -->
    <input
      type="checkbox"
      :value="item.id"
      :checked="item.checked"
      @change="
        $emit('check-changed', { id: item.id, checked: $event.target.checked })
      "
    />

    <!-- 기본 slot에 checked와 label 값을 담아서 부모에게 보냄 -->
    <slot :checked="item.checked" :label="item.label"></slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBoxList',
  // 부모에게서 items 받아옴
  props: ['items'],
};
</script>
